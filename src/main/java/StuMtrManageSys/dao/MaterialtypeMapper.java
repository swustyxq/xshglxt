package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Materialtype;
import StuMtrManageSys.selfmodel.MaterialtypeAndZone;
import StuMtrManageSys.selfmodel.UpdateMaterialType;

public interface MaterialtypeMapper {
    int deleteByPrimaryKey(String typeName);

    int insert(Materialtype record);

    int insertSelective(Materialtype record);

    Materialtype selectByPrimaryKey(String typeName);

    int updateByPrimaryKeySelective(Materialtype record);


    List<Materialtype> selectAllMaterialtype();

	List<MaterialtypeAndZone> selectAllMaterialtypeAndZone();

	boolean updateMaterialtype(UpdateMaterialType materialType);

	void updateByPrimaryKey(Materialtype record);
}