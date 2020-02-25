package cn.kgc.aviation.service.regulations.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.regulations.CascaderDao;
import cn.kgc.aviation.model.dto.DirectoryDto;
import cn.kgc.aviation.model.dto.Options;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.model.entity.Directory;
import cn.kgc.aviation.model.entity.RegulationsType;
import cn.kgc.aviation.service.regulations.CascaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-13 10:08
 * @version: V1.0
 **/
@Service
public class CascaderServiceImpl implements CascaderService {

    @Autowired
    private CascaderDao cascaderDao;

    private  ArrayList<DirectoryDto> list;
    private ArrayList<Integer> treeNodesList = new ArrayList<>();

    @Override
    public List<Options> showOptions() {
        ArrayList<Options> optionsList = new ArrayList<>();
        List<RegulationsType> regulationsTypes = cascaderDao.showType();
        for (int i = 0; i < regulationsTypes.size(); i++) {
            Options options = new Options();
            if (regulationsTypes.get(i).getRegulationsClassifyList().size() != 0) {
                ArrayList<Options> list = new ArrayList<>();
                options.setValue(regulationsTypes.get(i).getTypeId());
                options.setLabel(regulationsTypes.get(i).getTypeName());
                for (int j = 0; j < regulationsTypes.get(i).getRegulationsClassifyList().size(); j++) {
                    Options options1 = new Options();
                    options1.setLabel(regulationsTypes.get(i).getRegulationsClassifyList().get(j).getClassifyName());
                    options1.setValue(regulationsTypes.get(i).getRegulationsClassifyList().get(j).getClassifyId());
                    list.add(options1);
                }
                options.setChildren(list);
                optionsList.add(options);
            } else {
                options.setValue(regulationsTypes.get(i).getTypeId());
                options.setLabel(regulationsTypes.get(i).getTypeName());
                optionsList.add(options);
            }
        }
        return optionsList;
    }

    @Override
    public List<DirectoryDto> showDirOptions() {
        ArrayList<DirectoryDto> list = new ArrayList<>();
        List<Directory> allNodes = cascaderDao.getAllNodes();
        for (Directory item : allNodes) {
            DirectoryDto dto = new DirectoryDto(item);
            list.add(dto);
        }
        return listGetStree(list);
    }

    @Override
    public List<DirectoryDto> getDire(Integer rid) {
        list = new ArrayList<>();
        List<Directory> allNodes = cascaderDao.getDire(rid);
        for (Directory item : allNodes) {
            DirectoryDto dto = new DirectoryDto(item);
            list.add(dto);
        }
        return listGetStree(list);
    }

    @Override
    public List<RegulationsVo> getAllReg() {
        return cascaderDao.getAllReg();
    }

    @Logger("删除目录")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delDir(Integer rid, Integer did) throws Exception{
        int i = cascaderDao.delDir(did);
        if (i > 0) {
            cascaderDao.delTermsById(did);
            list = new ArrayList<>();
            List<Directory> allNodes = cascaderDao.getDire(rid);
            for (Directory item : allNodes) {
                DirectoryDto dto = new DirectoryDto(item);
                list.add(dto);
            }
            List<Integer> integers = treeMenuList(list, did);
            if (integers.size() > 0) {
                int d = cascaderDao.delTreeDir(integers);
                if (d > 0) {
                    Integer terms = cascaderDao.getTerms(integers);
                    if (terms == 0) {
                        return true;
                    }else {
                        int c = cascaderDao.delTerms(integers);
                        if (c > 0) {
                            return true;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private List<DirectoryDto> listGetStree(List<DirectoryDto> list) {
        List<DirectoryDto> treeList = new ArrayList<DirectoryDto>();
        for (DirectoryDto tree : list) {
            //找到根
            if (tree.getParentId() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (DirectoryDto treeNode : list) {
                if (treeNode.getParentId().equals(tree.getDid())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<DirectoryDto>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

    private List<Integer> treeMenuList(List<DirectoryDto> list, Integer did) {
        for (DirectoryDto directoryDto : list) {
            if (directoryDto.getParentId().equals(did)) {
                treeMenuList(list, directoryDto.getDid());
                treeNodesList.add(directoryDto.getDid());
            }
        }
        return treeNodesList;
    }


}
