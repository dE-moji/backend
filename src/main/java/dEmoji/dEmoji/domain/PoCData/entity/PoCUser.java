package dEmoji.dEmoji.domain.PoCData.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PoCUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pocId;

    private String diary;
    private String date;
    private String emoji;

    public PoCUser(String diary, String date, String emoji) {
        this.diary = diary;
        this.date = date;
        this.emoji = emoji;
    }

}
