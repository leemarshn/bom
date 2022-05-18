package com.kkc.bom.controller;

import com.kkc.bom.model.*;
import com.kkc.bom.repositories.*;
import com.kkc.bom.service.BomServiceImpl;
import com.kkc.bom.service.CogService;
import com.kkc.bom.service.FileHandlerCSV;
import com.kkc.bom.service.FileHandlerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 2:34 PM
 */

@Controller
public class MainController {


    @Autowired
    private ProductRepo  productRepository;

    @Autowired
    private BOMRepository bomRepository;

    @Autowired
    private RMRepository rmRepository;

    @Autowired
    private BomService bomService;
    @Autowired
    private CogRepo cogRepo;

    @Autowired
    private CogService cogService;

    @Autowired
    private FileHandlerService fileHandlerService;

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("proview", productRepository.findAll());
        return mav;
    }

    @GetMapping("/rm")
    public ModelAndView getRawMaterials(){
        ModelAndView mav = new ModelAndView("rawMaterials");
        mav.addObject("materials", rmRepository.findAll() );
        return mav;
    }

    @GetMapping("/allProducts")
    public ModelAndView getAllProducts(){
        ModelAndView mav = new ModelAndView("allProducts");
        BomServiceImpl bomService = new BomServiceImpl();
        mav.addObject("rates", bomService );
        mav.addObject("costings", cogRepo.findAll());
        return mav;
    }

    @GetMapping("/addProductFRM")
    public ModelAndView pmForm() {
        ModelAndView mav = new ModelAndView("addProduct");
        ProductModel pm = new ProductModel();
        mav.addObject("product", pm);
        return mav;
    }

    @GetMapping("/addRawMaterial")
    public String addRawMaterials(Model model) {
        model.addAttribute("rm", new RawMaterial());
        return "addRm";
    }

    @GetMapping("/assign-bom{id}")
    public String updateBOM(@RequestParam("id") Long id, Model model) {
        ProductModel productModel = productRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:" + id));
        BOM bom = new BOM();
        model.addAttribute("bom", bom );
        model.addAttribute("products", productModel);
        model.addAttribute("rms", rmRepository.findAll());
        model.addAttribute("bomById", bomRepository.findBOMById(id));
        model.addAttribute("costOfGoods", bomService.getCostOfGoods(id));
        model.addAttribute("productionCost", bomService.getProductionCost(bomService.getCostOfGoods(id)));
        model.addAttribute("wholeSalePrice", bomService.getWholeSaleCost(bomService.getCostOfGoods(id)));
        model.addAttribute("retailPrice", bomService.getRetailCost(bomService.getCostOfGoods(id)));

        return "addBOM";

    }


    @GetMapping("/configRates")
    public String setDefaultRates(Model model) {
        model.addAttribute("defaultRates", new DefaultRates());
        return "set-default-rates";
    }

    @GetMapping("/get-rates")
    public String getRates() {
        return "default-rates";
    }

    @PostMapping("/saveBOM")
    public String  saveBOM(@ModelAttribute BOM bom) {
        bomRepository.save(bom);
        Long id = bom.getProductModel().getId();
        cogService.saveCog(id);
        return "redirect:/assign-bom?id="+id;
    }

    @PostMapping("/saveProduct")
    public String  addProduct(@ModelAttribute ProductModel pm) {
        productRepository.save(pm);
        return "redirect:/";
    }



    @PostMapping("/saveRM")
    public String saveRawMaterial(@ModelAttribute RawMaterial rm){
        rmRepository.save(rm);
        return "redirect:/addRawMaterial";
    }


    @GetMapping("/upload-rm")
    public String uploadRM(Model model){
        model.addAttribute("rm", new RawMaterial());
        return "import-raw-materials";
    }

    @PostMapping("/uploadRM")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        fileHandlerService.save(file.getOriginalFilename());
//        model.addAttribute("import", fileHandlerService.save(file.getOriginalFilename()));
        return "/rawMaterials";
        }

    @GetMapping("/upload-pm")
    public String uploadP(Model model){
        model.addAttribute("uploadPM", new ProductModel());
        return "/import-products";
    }

    @PostMapping("save-pm")
    public String uploadPM(@RequestParam("file") MultipartFile file) {
        fileHandlerService.saveProducts(file.getOriginalFilename());
//        model.addAttribute("import", fileHandlerService.save(file.getOriginalFilename()));
        return "/home";
    }


    @GetMapping("/edit-rm/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RawMaterial rawMaterial = rmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("rawMaterialUpdate", rawMaterial);
        return "update-raw";
    }


    @PostMapping("/update-rm/{id}")
    public String updateRM(@PathVariable("id") long id, RawMaterial rawMaterial){
        rmRepository.save(rawMaterial);
        return "redirect:/rm";
    }

    @GetMapping("/delete-rm/{id}")
    public String deleteRM(@PathVariable("id") long id, Model model) {
        RawMaterial rawMaterial = rmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        rmRepository.delete(rawMaterial);
        return "redirect:/rm";
    }

    @GetMapping("/delete-cog/{id}")
    public String deleteCOG(@PathVariable("id") long id) {
        CostOfGoods costOfGoods = cogRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        cogRepo.delete(costOfGoods);
        return "redirect:/allProducts";
    }

    @GetMapping("/remove-bom/{id}")
    public String removeBOM(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
      BOM bom =  bomRepository.findById(id).
              orElseThrow(() -> new IllegalArgumentException("Invalid BOM Id:" + id));
        bomService.deleteBOM(id);
        redirectAttributes.addAttribute("id",bom.getProductModel().getId());
        return "redirect:/assign-bom";
    }

    @GetMapping("/download-costings")
    public ResponseEntity<Resource> getFile() {
        String filename = "kkcCostings.csv";
        InputStreamResource file = new InputStreamResource(fileHandlerService.load());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

}
