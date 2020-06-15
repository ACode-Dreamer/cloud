package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * cd_user
 * @author 
 */
@Data
public class CdUser implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String telephone;

    private String email;

    private Integer roleid;

    private String isvip;

    private Integer status;

    private static final long serialVersionUID = 1L;
}