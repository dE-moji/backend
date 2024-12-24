package dEmoji.dEmoji.domain.PoCData.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PoCUserDTO {
    private String diary;
    private String date;
    private String emoji;

    public PoCUserDTO(String diary, String date, String emoji) {
        this.diary = diary;
        this.date = date;
        this.emoji = emoji;
    }
}
