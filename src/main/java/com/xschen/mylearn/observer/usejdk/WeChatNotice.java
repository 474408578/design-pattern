package com.xschen.mylearn.observer.usejdk;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xschen
 */

@Data
@AllArgsConstructor
public class WeChatNotice {
    private String publisher;
    private String articleName;
}
