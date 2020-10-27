package com.xschen.mylearn.observer.natural;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xschen
 * 用于封装通知消息
 */

@Data
@AllArgsConstructor
public class WeChatNoticeDTO {
    private String publisher;
    private String articleName;
}
