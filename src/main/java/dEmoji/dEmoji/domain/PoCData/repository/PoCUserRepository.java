package dEmoji.dEmoji.domain.PoCData.repository;

import dEmoji.dEmoji.domain.PoCData.entity.PoCUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoCUserRepository extends JpaRepository<PoCUser, Long> {
    Optional<PoCUser> findPoCUserByPocId(Long pocId);
}
