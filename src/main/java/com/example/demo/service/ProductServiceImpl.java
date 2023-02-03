package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepository productRepository;

    public void loadDB() {
        Product product1 = new Product("accent chair", 25999, "https://images2.imgbox.com/38/85/iuYyO9RP_o.jpeg", new String[]{"#ff0000","#00ff00","#0000ff"}, "marcos", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "office", true, new String[]{"https://images2.imgbox.com/38/85/iuYyO9RP_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},8,true);
        Product product2 = new Product("albany sectional", 109999, "https://images2.imgbox.com/36/c5/mgSP2SV2_o.jpeg", new String[]{"#000","#ffb900"}, "liddy", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "living room", false, new String[]{"https://images2.imgbox.com/36/c5/mgSP2SV2_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},7,false);
        Product product3 = new Product("albany table", 309999, "https://images2.imgbox.com/ca/86/S0xjwQ1l_o.jpeg", new String[]{"#ffb900","#0000ff"}, "liddy", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "living room", true, new String[]{"https://images2.imgbox.com/ca/86/S0xjwQ1l_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},11,true);
        Product product4 = new Product("dining table", 42999, "https://images2.imgbox.com/45/1a/IhY9dl95_o.jpeg", new String[]{"#00ff00","#0000ff","#ff0000"}, "ikea", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "dining", false, new String[]{"https://images2.imgbox.com/45/1a/IhY9dl95_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},14,true);
        Product product5 = new Product("emperor bed", 23999, "https://images2.imgbox.com/ba/e2/q0XmH4ZV_o.jpeg", new String[]{"#0000ff","#000"}, "ikea", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "bedroom", true, new String[]{"https://images2.imgbox.com/ba/e2/q0XmH4ZV_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},6,true);
        Product product6 = new Product("entertainment center", 59999, "https://images2.imgbox.com/cb/69/cQ29pV1x_o.jpeg", new String[]{"#000","#ff0000"}, "caressa", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "bedroom", true, new String[]{"https://images2.imgbox.com/cb/69/cQ29pV1x_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},23,false);
        Product product7 = new Product("high-back bench", 39999, "https://images2.imgbox.com/b4/3d/2jm4sPHs_o.jpeg", new String[]{"#000","#00ff00"}, "ikea", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "office", false, new String[]{"https://images2.imgbox.com/b4/3d/2jm4sPHs_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},0,true);
        Product product8 = new Product("leather chair", 39999, "https://images2.imgbox.com/fa/23/Pqoxb7z6_o.jpeg", new String[]{"#000","#00ff00"}, "ikea", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "office", true, new String[]{"https://images2.imgbox.com/fa/23/Pqoxb7z6_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},4,false);
        Product product9 = new Product("modern bookshelf", 31999, "https://images2.imgbox.com/c7/9c/2GpPoQKF_o.jpeg", new String[]{"#ffb900","#ff0000","#00ff00"}, "caressa", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "kids", true, new String[]{"https://images2.imgbox.com/c7/9c/2GpPoQKF_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},6,false);
        Product product10 = new Product("wooden table", 234999, "https://images2.imgbox.com/44/7e/TJCBoMAa_o.jpeg", new String[]{"#ffb900","#ff0000"}, "caressa", "Cloud bread VHS hell of banjo bicycle rights jianbing umami mumblecore etsy 8-bit pok pok +1 wolf. Vexillologist yr dreamcatcher waistcoat, authentic chillwave trust fund. Viral typewriter fingerstache pinterest", "kitchen", false , new String[]{"https://images2.imgbox.com/44/7e/TJCBoMAa_o.jpeg","https://images2.imgbox.com/da/bb/iXlbK9A6_o.jpeg","https://images2.imgbox.com/6d/47/A11k7xmf_o.jpeg","https://images2.imgbox.com/ca/f3/rPR1K8nP_o.jpeg"},6,false);


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
    }

    public List<Product> getAll(){
       return productRepository.findAll();
    }

    public  Product getById(Long id){
        return  productRepository.findById(id).get();
    }

    public void edit(Product product){
        Product oldProduct=productRepository.findById(product.getId()).get();
        String [] oldImages=oldProduct.getImages();
        oldImages[0]=product.getImage();
        oldProduct.setImages(oldImages);
        oldProduct.setImage(product.getImage());
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStock(product.getStock());
        oldProduct.setCompany(product.getCompany());
        productRepository.save(oldProduct);
    }

}
