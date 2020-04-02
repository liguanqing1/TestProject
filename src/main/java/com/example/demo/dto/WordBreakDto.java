package com.example.demo.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class WordBreakDto implements Serializable {
    /**
     * 句子输入
     */
    private String sentence;
    /**
     * 字典集合
     */
    private String dic;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }
}
