package generate;

import generate.CdUser;

public interface CdUserDao {
    int insert(CdUser record);

    int insertSelective(CdUser record);
}