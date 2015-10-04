package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer mtrId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer mtrId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKeyWithBLOBs(Material record);

    int updateByPrimaryKey(Integer mtrId);

    List<Material> selectAll();

    List<Material> selectMtrByTypeAndDept(Material material);

    List<Material> selectByDept(Material material);

    List<Material> selectByType(Material material);

	void updateByPrimaryKey(Material material);

	List<Material> selectMtrByName(String mtrName);

	List<Material> selectMtrByType(String mtrType);

	List<Material> selectMtrByDept(String mtrDeptname);

	List<Material> selectAllCanBorrow();
}