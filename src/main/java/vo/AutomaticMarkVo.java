package vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("automaticmark")
public class AutomaticMarkVo {
    private Long score;
    private Long id;
    private int page;
    private int pageline;
    private String correctAnswer;
    private String studentAnswer;
    private String questionContents;
    private String questionType;
    private String creatTime;
    private String creatBy;
}
