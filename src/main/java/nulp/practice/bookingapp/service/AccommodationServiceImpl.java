package nulp.practice.bookingapp.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.AccommodationDto;
import nulp.practice.bookingapp.dto.AddAccommodationDto;
import nulp.practice.bookingapp.mapper.AccommodationMapper;
import nulp.practice.bookingapp.model.Accommodation;
import nulp.practice.bookingapp.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationMapper accommodationMapper;

    @Override
    public AccommodationDto add(AddAccommodationDto addAccommDto) {
        return accommodationMapper.toDto(accommodationRepository.save(
                        accommodationMapper.toModel(addAccommDto)));
    }

    @Override
    public List<AccommodationDto> getAll() {
        return accommodationRepository.findAll().stream()
                .map(accommodationMapper::toDto)
                .toList();
    }

    @Override
    public AccommodationDto getById(Long id) {
        return accommodationMapper.toDto(
                accommodationRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Can't find accommodation by id " + id))
        );
    }

    @Override
    public AccommodationDto updateById(Long id, AddAccommodationDto addAccommDto) {
        if (!accommodationRepository.existsById(id)) {
            throw new RuntimeException("Can't find accommodation by id " + id);
        }
        Accommodation accommodation = accommodationMapper.toModel(addAccommDto);
        accommodation.setId(id);
        return accommodationMapper.toDto(accommodationRepository.save(accommodation));
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
