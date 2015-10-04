package StuMtrManageSys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.MaterialMapper;
import StuMtrManageSys.model.Material;
import StuMtrManageSys.service.MaterialService;

/**
 * @author LJY
 * 
 */
  
/**.   
 * 类名：  MaterialServiceImpl 
 * 描述：  物资服务类
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:45:07    
 */   
    
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    private MaterialMapper materialMapper;

    public MaterialMapper getMaterialMapper() {
        return materialMapper;
    }

    @Autowired
    public void setMaterialMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

      
    /* (non-Javadoc)   
     * Title: findByMaterialId
     * Description: 通过ID查找物资
     * @param materialId  物资ID
     * @return   物资简单对象
     * @see StuMtrManageSys.service.MaterialService#findByMaterialId(int)
     */  
    @SuppressWarnings("finally")
    public Material findByMaterialId(int materialId) {
        Material material = null;
        try {
            material = materialMapper.selectByPrimaryKey(materialId);
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            return material;
        }
    }


      
    /* (non-Javadoc)   
     * Title: insertMaterial
     * Description: 插入物资
     * @param material 物资简单对象
     * @return  bool类型变量
     * @see StuMtrManageSys.service.MaterialService#insertMaterial(StuMtrManageSys.model.Material)
     */  
    public Boolean insertMaterial(Material material) {
        // TODO Auto-generated method stub
        try {
            materialMapper.insert(material);
        } catch (Exception e) {
           return false;
        } 
        return true;
    }

      
    /* (non-Javadoc)   
     * Title: deleteMaterial
     * Description: 删除物资
     * @param mtrId  物资ID
     * @return   bool类型变量
     * @see StuMtrManageSys.service.MaterialService#deleteMaterial(java.lang.Integer)
     */  
    @SuppressWarnings("finally")
    public boolean deleteMaterial(Integer mtrId) {
        try {
            materialMapper.deleteByPrimaryKey(mtrId);
        } catch (Exception e) {
            return false;
        } finally{
        	 return true;
        }
    }
  
      
    /* (non-Javadoc)   
     * Title: updateMaterial
     * Description: 更新物资
     * @param material  物资类型对象
     * @return    bool类型变量
     * @see StuMtrManageSys.service.MaterialService#updateMaterial(StuMtrManageSys.model.Material)
     */  
    public boolean updateMaterial(Material material) {
        try {
            materialMapper.updateByPrimaryKey(material);
        } catch (Exception e) {
            return false;
        } 
        return true;
    }

      
    /* (non-Javadoc)   
     * Title: selectAllMaterial
     * Description: 查询所有物资
     * @return    物资类型list
     * @see StuMtrManageSys.service.MaterialService#selectAllMaterial()
     */  
    @SuppressWarnings("finally")
    public List<Material> selectAllMaterial() {
        List<Material> list = new ArrayList<Material>();
        try {
            list = materialMapper.selectAll();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

      
    /* (non-Javadoc)   
     * Title: selectByPrimaryKey
     * Description:  通过id查询物资
     * @param material  物资类型对象
     * @return   物资简单对象
     * @see StuMtrManageSys.service.MaterialService#selectByPrimaryKey(StuMtrManageSys.model.Material)
     */  
    @SuppressWarnings("finally")
    public Material selectByPrimaryKey(Material material) {
        Material material2 = null;
        try {
            material2 = materialMapper.selectByPrimaryKey(material.getMtrId());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return material2;
        }
    }

      
    /* (non-Javadoc)   
     * Title: findMtrByDeptAndType
     * Description:  按类型、部门查找物资
     * @param mtrType  物资类型
     * @param mtrDept  物资部门
     * @return    物资类型list
     * @see StuMtrManageSys.service.MaterialService#findMtrByDeptAndType(java.lang.String, java.lang.String)
     */  
    @SuppressWarnings("finally")
    public List<Material> findMtrByDeptAndType(String mtrType, String mtrDept) {
        List<Material> materials = null;
        try {
            Material material = new Material();
            if (mtrType.equals("全部") && mtrDept.equals("全部")){
               materials = materialMapper.selectAllCanBorrow(); 
            }else if (mtrType.equals("全部")){
                material.setMtrDeptname(mtrDept);
                materials = materialMapper.selectByDept(material);
            }else if(mtrDept.equals("全部")){
                material.setMtrType(mtrType);
                materials = materialMapper.selectByType(material);
            }else{
                material.setMtrDeptname(mtrDept);
                material.setMtrType(mtrType);
                materials = materialMapper.selectMtrByTypeAndDept(material);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            return materials;
        }
    }

	  
	/* (non-Javadoc)   
	 * Title: findByMaterialName
	 * Description: 通过物资名称查询物资
	 * @param input   物资名称
	 * @return     物资list
	 * @see StuMtrManageSys.service.MaterialService#findByMaterialName(java.lang.String)
	 */  
	public List<Material> findByMaterialName(String input) {
		// TODO Auto-generated method stub
		List<Material> materials=null;
		try {
			materials=materialMapper.selectMtrByName(input);
		} catch (Exception e) {
			System.out.println(e);
		}
		return materials;
	}

	  
	/* (non-Javadoc)   
	 * Title: findByMaterialType
	 * Description: 通过物资类型查找物资
	 * @param input  物资类型
	 * @return   物资类型list
	 * @see StuMtrManageSys.service.MaterialService#findByMaterialType(java.lang.String)
	 */  
	public List<Material> findByMaterialType(String input) {
		List<Material> materials = null;
		try {
			materials=materialMapper.selectMtrByType(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materials;
	}

	  
	/* (non-Javadoc)   
	 * Title: findByMaterialDept
	 * Description: 通过物资部门 查找物资
	 * @param input  物资部门
	 * @return     物资list
	 * @see StuMtrManageSys.service.MaterialService#findByMaterialDept(java.lang.String)
	 */  
	public List<Material> findByMaterialDept(String input) {
		// TODO Auto-generated method stub
		List<Material> materials = null;
		try {
			materials=materialMapper.selectMtrByDept(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materials;
	}


	  
	/* (non-Javadoc)   
	 * Title: updateMtrNum
	 * Description:  更新物资数量
	 * @param mtrId  物资ID
	 * @param mtrNum  物资数量
	 * @return    bool类型变量
	 * @see StuMtrManageSys.service.MaterialService#updateMtrNum(int, int)
	 */  
	public boolean updateMtrNum(int mtrId, int mtrNum) {
		try {
			Material material = new Material();
			material.setMtrId(mtrId);
			material.setMtrStocknum(mtrNum);
			materialMapper.updateByPrimaryKeySelective(material);
		} catch (Exception e) {
			return false;
		}
			return true;
	}



}
