package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String addressId;
    private String provinces;
    private String city;
}
