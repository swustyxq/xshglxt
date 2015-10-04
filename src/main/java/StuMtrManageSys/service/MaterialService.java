package StuMtrManageSys.service;

import java.util.List;

import StuMtrManageSys.model.Material;

public interface MaterialService {
    public Material findByMaterialId(int materialId);

    public Boolean insertMaterial(Material material);

    public boolean deleteMaterial(Integer mtrIdl);

    public boolean updateMaterial(Material materia);

    public List<Material> selectAllMaterial();

    public Material selectByPrimaryKey(Material material);

    public List<Material> findMtrByDeptAndType(String mtrType, String mtrDept);

	public List<Material> findByMaterialName(String input);

	public List<Material> findByMaterialType(String input);

	public List<Material> findByMaterialDept(String input);

	public boolean updateMtrNum(int mtrId, int mtrNum);


}
