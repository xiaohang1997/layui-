package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCountVO;
import com.example.demo.entity.ProductVO;
import com.example.demo.service.ProductService;
import com.example.demo.until.FileUtils;
import com.example.demo.until.JsonResult;
import com.example.demo.until.Result;
import com.example.demo.until.ResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("queryAll")
    public ResultVO queryAllByLimit(int page, int limit){
        PageInfo pageInfo = productService.queryAllByLimit(page,limit);
        int total = (int)pageInfo.getTotal();
        ResultVO<Product> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("insert")
    public JSONObject insert(@RequestBody ProductVO productVO){
        if (productService.insert(productVO)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("update")
    public JSONObject update(@RequestBody ProductVO productVO){
        if (productService.update(productVO)){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("deleteMany")
    public JSONObject deleteMany(@RequestParam(name = "data") List<Integer> data){
        for (Integer integer: data){
            if (!productService.deleteById(integer)){
                return JsonResult.sendError();
            }
        }
        return JsonResult.sendSuccess();
    }

    @RequestMapping("deleteById")
    public JSONObject deleteById(Integer id){
        boolean b = productService.deleteById(id);
        if (b){
            return JsonResult.sendSuccess();
        }
        else return JsonResult.sendError();
    }

    @RequestMapping("search")
    public ResultVO search(int page, int limit, @RequestParam Map<String, String> map){
        String string = map.get("searchParams");
        String name = string.split("\"")[3];
        ProductVO productVO = new ProductVO();
        productVO.setName(name);
        PageInfo pageInfo = productService.queryAll(page,limit,productVO);
        int total = (int)pageInfo.getTotal();
        ResultVO<Product> resultVO = new ResultVO();
        resultVO.setCount(total);
        List list = pageInfo.getList();
        resultVO.setList(list);
        return resultVO;
    }

    @RequestMapping("searchNameAndCount")
    public ResultVO searchNameAndCount(){
        List list = productService.searchNameAndCount();
        ResultVO<ProductCountVO> resultVO = new ResultVO();
        resultVO.setList(list);
        return resultVO;
    }

//    @PostMapping("/projectPictureUpload")
//    @ResponseBody
//    public JSONObject projectPictureUpload(@RequestParam(value = "projectImg",required = true) MultipartFile file){
//        //将图片上传到服务器
//        if(file.isEmpty()){
//            return Result.error(ResultCodeConstants.UPLOAD_FAIL,"项目图片不能为空");;
//        }
//        //原始文件名
//        String originalFilename = file.getOriginalFilename();
//        //文件后缀
//        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
//        //图片名称为uuid+图片后缀防止冲突
//        String fileName = UUID.randomUUID().toString()+"."+suffix;
//        String os = System.getProperty("os.name");
//        //文件保存路径
//        String filePath="";
//        if(os.toLowerCase().startsWith("win")){
//            //windows下的路径
//            filePath ="d:/pictureUpload/project/";
//        }else {
//            //linux下的路径
//            filePath="/root/pictureUpload/project/";
//        }
//        try {
//            //写入图片
//            Boolean writePictureflag = FileUtils.uploadFile(file.getBytes(),filePath,fileName);
//            if(writePictureflag == false){
//                //上传图片失败
//                return JsonResult.sendError();
//            }
//            //上传成功后，将可以访问的完整路径返回
//            String fullImgpath = "/pictureUpload/project/"+fileName;
//            return JsonResult.sendSuccess();
//        } catch (Exception e) {
//            e.printStackTrace();
//            //上传图片失败
//            return JsonResult.sendError();
//        }
//    }

}
