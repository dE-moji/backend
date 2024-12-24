package dEmoji.dEmoji.domain.PoCData.service;

import dEmoji.dEmoji.domain.PoCData.dto.PoCUserDTO;
import dEmoji.dEmoji.domain.PoCData.dto.PoCUserRequest;
import dEmoji.dEmoji.domain.PoCData.entity.PoCUser;
import dEmoji.dEmoji.domain.PoCData.repository.PoCUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoCUserService {
    private final PoCUserRepository poCUserRepository;

    public void saveUserData(PoCUserDTO pocUserDTO) {
        PoCUser pocUser = new PoCUser(pocUserDTO.getDiary(), pocUserDTO.getDate(), pocUserDTO.getEmoji());
        poCUserRepository.save(pocUser);
    }

    public PoCUserDTO getUserData(PoCUserRequest pocUserRequest) {
        PoCUser pocUser = poCUserRepository.findPoCUserByPocId(pocUserRequest.getPocId())
                .orElse(null);
        return new PoCUserDTO(pocUser.getDiary(), pocUser.getDate(),pocUser.getEmoji());
    }
}
