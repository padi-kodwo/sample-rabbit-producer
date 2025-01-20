package co.terydin.rabbitproducer.dto;


import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
public class UserDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 6613471837742199375L;

  private String id;

  private String name;

  private String dateOfBirth;

  private String createdAt;

  private String modifiedAt;
}
