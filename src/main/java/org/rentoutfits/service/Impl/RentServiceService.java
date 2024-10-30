package org.rentoutfits.service.Impl;

import org.rentoutfits.dto.request.RentServiceDTO;
import org.rentoutfits.dto.response.ClientResponseDTO;
import org.rentoutfits.dto.response.ClothingLaundryResponseDTO;
import org.rentoutfits.dto.response.RentServiceResponseDTO;
import org.rentoutfits.entity.Client;
import org.rentoutfits.entity.Clothing;
import org.rentoutfits.entity.Employee;
import org.rentoutfits.entity.RentService;
import org.rentoutfits.repository.ClientRepository;
import org.rentoutfits.repository.ClothingRepository;
import org.rentoutfits.repository.EmployeeRepository;
import org.rentoutfits.repository.RentServiceRepository;
import org.rentoutfits.service.IRentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentServiceService implements IRentService {
    private final Logger LOGGER = LoggerFactory.getLogger(RentServiceService.class);
    private final RentServiceRepository serviceRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final ClothingRepository clothingRepository;

    @Autowired
    public RentServiceService(RentServiceRepository serviceRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository, ClothingRepository clothingRepository) {
        this.serviceRepository = serviceRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.clothingRepository = clothingRepository;
    }

    @Override
    public ResponseEntity<?> save(RentServiceDTO rent) {
        RentService service = new RentService();
        RentServiceResponseDTO responseDTO = new RentServiceResponseDTO();
        Optional<Client> client = clientRepository.findById(rent.getClientId());
        service.setClient(client.get());
        service.setDateRequest(new Date());
        Optional<Employee> employee = employeeRepository.findById(rent.getEmployeeId());
        service.setEmployee(employee.get());
        service.setNumber(rent.getQuantity());
        List<Clothing> clothingList = new ArrayList<>();
        for (Integer clothing : rent.getClothingList()) {
            Optional<Clothing> clothingOptional = clothingRepository.findByRef(clothing);
            LOGGER.info("Clothing found: {}", clothingOptional.isPresent());
            clothingList.add(clothingOptional.get());
        }
        service.setClothings(clothingList);
        service.setDateRent(fromStringToDate(rent.getDateRent()));
        serviceRepository.save(service);
        responseDTO.setId(service.getNumber());
        responseDTO.setDateRequest(service.getDateRequest().toString());
        responseDTO.setDateRent(service.getDateRent().toString());
        responseDTO.setEmployeeId(service.getEmployee().getId());
        responseDTO.setClientId(service.getClient().getId());
        responseDTO.setClothingList(getRefs(service.getClothings()));


        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<?> getRentServiceById(int rentServiceId) {
        Optional<RentService> service = serviceRepository.findById(rentServiceId);

        RentServiceResponseDTO serviceResponseDTO = new RentServiceResponseDTO();
        serviceResponseDTO.setDateRequest(service.get().getDateRequest().toString());
        serviceResponseDTO.setDateRent(service.get().getDateRent().toString());
        serviceResponseDTO.setEmployeeId(service.get().getEmployee().getId());
        serviceResponseDTO.setId(service.get().getNumber());
        serviceResponseDTO.setClientId(service.get().getClient().getId());
        serviceResponseDTO.setClothingList(getRefs(service.get().getClothings()));
        return ResponseEntity.ok(serviceResponseDTO);
    }

    @Override
    public ResponseEntity<?> getRentServiceByClient(int clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        List<RentServiceResponseDTO> rentServiceResponseDTOList = new ArrayList<>();
        List<RentService> service = serviceRepository.findByClient(client);
        for (RentService rentService : service) {
            RentServiceResponseDTO rentServiceResponseDTO = new RentServiceResponseDTO();
            rentServiceResponseDTO.setId(rentService.getNumber());
            rentServiceResponseDTO.setClientId(rentService.getNumber());
            rentServiceResponseDTO.setDateRent(rentService.getDateRent().toString());
            rentServiceResponseDTO.setDateRequest(rentService.getDateRequest().toString());
            rentServiceResponseDTO.setEmployeeId(rentService.getEmployee().getId());
            rentServiceResponseDTO.setClothingList(getRefs(rentService.getClothings()));
            rentServiceResponseDTOList.add(rentServiceResponseDTO);
        }
        return ResponseEntity.ok(rentServiceResponseDTOList);
    }

    @Override
    public ResponseEntity<?> getAllRentServices() {
        return null;
    }

    @Override
    public ResponseEntity<?> getRentServicesByDateRent(String dateRent) {
        Date date = fromStringToDate(dateRent);
        Optional<RentService> service = serviceRepository.findByDateRent(date);
        RentServiceResponseDTO serviceResponseDTO = new RentServiceResponseDTO();
        serviceResponseDTO.setDateRequest(service.get().getDateRequest().toString());
        serviceResponseDTO.setDateRent(service.get().getDateRent().toString());
        serviceResponseDTO.setEmployeeId(service.get().getEmployee().getId());
        serviceResponseDTO.setClothingList(getRefs(service.get().getClothings()));
        serviceResponseDTO.setId(service.get().getNumber());
        serviceResponseDTO.setClientId(service.get().getClient().getId());

        return ResponseEntity.ok(serviceResponseDTO);
    }

    @Override
    public ResponseEntity<?> clothingToLaundry(int clothingId) {
        Optional<Clothing> clothingOptional = clothingRepository.findById(clothingId);

        if (clothingOptional.isPresent()) {
            ClothingLaundryResponseDTO laundryResponseDTO = new ClothingLaundryResponseDTO();
            Clothing clothing = clothingOptional.get();
            clothing.setAvailable(false);
            clothingRepository.save(clothing);
            laundryResponseDTO.setRef(clothing.getRef());
            laundryResponseDTO.setSize(clothing.getSize());
            laundryResponseDTO.setPrice(clothing.getPrice());
            laundryResponseDTO.setColor(clothing.getColor());
            laundryResponseDTO.setAvailable(clothing.getAvailable());
            laundryResponseDTO.setBrand(clothing.getBrand());
            laundryResponseDTO.setRentServices(getIds(clothing.getRentService()));
            return ResponseEntity.ok(laundryResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> getAllClothingByLaundry() {
        List<Clothing> clothingList = clothingRepository.findAllByAvailable(false);
        List<ClothingLaundryResponseDTO> laundryResponseDTOList = new ArrayList<>();
        for (Clothing clothing : clothingList) {
            ClothingLaundryResponseDTO laundryResponseDTO = new ClothingLaundryResponseDTO();
            laundryResponseDTO.setRef(clothing.getRef());
            laundryResponseDTO.setSize(clothing.getSize());
            laundryResponseDTO.setPrice(clothing.getPrice());
            laundryResponseDTO.setColor(clothing.getColor());
            laundryResponseDTO.setAvailable(clothing.getAvailable());
            laundryResponseDTO.setBrand(clothing.getBrand());
            laundryResponseDTO.setRentServices(getIds(clothing.getRentService()));
            laundryResponseDTOList.add(laundryResponseDTO);
        }
        return ResponseEntity.ok(laundryResponseDTOList);
    }


    private Date fromStringToDate(String dateString) {
        // LOGGER.info("dateString: {}", dateString);
        if (dateString == null || dateString.trim().isEmpty()) {
            //   LOGGER.info("La fecha en formato String no puede ser nula o vacía");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);

        // Convertir LocalDate a Date
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private static List<Integer> getRefs(List<Clothing> clothings) {
        return clothings.stream()
                .map(Clothing::getRef)
                .collect(Collectors.toList());
    }
    private static List<Integer> getIds(List<RentService> rentServicest) {
        return rentServicest.stream()
                .map(RentService::getNumber)
                .collect(Collectors.toList());
    }

}
