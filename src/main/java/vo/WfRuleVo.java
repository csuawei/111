package vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wf_exam_rule")
public class WfRuleVo {
    private int ruleId;
    private String ruleContent;
    private int ruleName;
    private int page;
    private int pageLine;
    private String createTime;
    private String createBy;
}
