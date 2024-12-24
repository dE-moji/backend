package dEmoji.dEmoji.domain.PoCData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoveCheck {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poc_id", nullable = false, unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PoCUser pocUser;

    //해당 유저가 접근하는 페이지가 이 정도로만 구분되었다고 생각하고 작성
    private long page1 = 0 ;
    private long page2 = 0 ;
    private long page3 = 0 ;
    private long page4 = 0 ;
    private long page5 = 0 ;
    private long page6 = 0 ;

}
