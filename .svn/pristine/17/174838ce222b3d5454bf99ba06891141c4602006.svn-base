package StuMtrManageSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.MaterialtypeMapper;
import StuMtrManageSys.model.Materialtype;
import StuMtrManageSys.selfmodel.MaterialtypeAndZone;
import StuMtrManageSys.selfmodel.UpdateMaterialType;
import StuMtrManageSys.service.MaterialtypeService;

  
/**.  
 * 类名：  MaterialtypeServiceImpl 
 * 描述：  物资类型类
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:53:51    
 */   
    
@Service("materialtypeService")
public class MaterialtypeServiceImpl implements MaterialtypeService {

    private MaterialtypeMapper materialtypeMapper;

    public MaterialtypeMapper getMaterialtypeMapper() {
        return materialtypeMapper;
    }

    @Autowired
    public void setMaterialtypeMapper(MaterialtypeMapper materialtypeMapper) {
        this.materialtypeMapper = materialtypeMapper;
    }

      
    /* (non-Javadoc)   
     * Title: insertMaterialtype
     * Description: 增减物资类型
     * @param materialtype  物资类型对象
     * @return        bool类型变量
     * @see StuMtrManageSys.service.MaterialtypeService#insertMaterialtype(StuMtrManageSys.model.Materialtype)
     */  
    public boolean insertMaterialtype(Materialtype materialtype) {
        // TODO Auto-generated method stub
        try {
            materialtypeMapper.insert(materialtype);
        } catch (Exception e) {
        	return false;
        } 
        return true;
    }

      
    /* (non-Javadoc)   
     * Title: deleteMaterialtype
     * Description:删除物资类型
     * @param materialtype 物资类型对象
     * @see StuMtrManageSys.service.MaterialtypeService#deleteMaterialtype(StuMtrManageSys.model.Materialtype)
     */  
    @SuppressWarnings("finally")
    public void deleteMaterialtype(Materialtype materialtype) {
        // TODO Auto-generated method stub
        try {
            materialtypeMapper.deleteByPrimaryKey(materialtype.getTypeName());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return;
        }
    }

      
    /* (non-Javadoc)   
     * Title: updateMaterialtype
     * Description: 更新物资类型
     * @param record  物资类型对象
     * @return  bool类型变量
     * @see StuMtrManageSys.service.MaterialtypeService#updateMaterialtype(StuMtrManageSys.model.Materialtype)
     */  
    public boolean updateMaterialtype(Materialtype record) {
        try {
           materialtypeMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } 
        return true;
    }

      
    /* (non-Javadoc)   
     * Title: selectAllMateriatypel
     * Description: 查询所有物资类型
     * @return    物资类型list
     * @see StuMtrManageSys.service.MaterialtypeService#selectAllMateriatypel()
     */  
    @SuppressWarnings("finally")
    public List<Materialtype> selectAllMateriatypel() {
        List<Materialtype> list = null;
        try {
            list = materialtypeMapper.selectAllMaterialtype();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }

	  
	/* (non-Javadoc)   
	 * Title: selectAllMaterialtypeAndZone
	 * Description: 查询物资类型和区域
	 * @return   物资类型和区域list
	 * @see StuMtrManageSys.service.MaterialtypeService#selectAllMaterialtypeAndZone()
	 */  
	@Override
	public List<MaterialtypeAndZone> selectAllMaterialtypeAndZone() {
		List<MaterialtypeAndZone> materialtypeAndZones=null;
		try {
			materialtypeAndZones=materialtypeMapper.selectAllMaterialtypeAndZone();
		} catch (Exception e) {
			System.out.println(e);
		}
		return materialtypeAndZones;
	}
}
