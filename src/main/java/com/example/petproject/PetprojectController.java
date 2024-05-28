package com.example.petproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@RestController
@NoArgsConstructor
@AllArgsConstructor

@RequestMapping("/pet")
public class PetprojectController {

    @Autowired
    private PetprojectRepository pprepo;
    
    @GetMapping("/all")
    public Iterable<Petproject> getAllPets(){
        return pprepo.findAll();
    }

    @PostMapping
    public void save(@RequestBody Petproject pets) {
        pprepo.save(pets);
    }
    
    @PutMapping("/{Id}")
    public void update(@PathVariable String Id, @RequestBody Petproject pets) {
        pprepo.save(pets);
    }
    
     @GetMapping("/getdog")
     public String getDetailsDogs(){
         List<Petproject> ld = pprepo.findByType("dog");
         String doghtml = "<html>\n" +
                          "    <body>\n" +
                          "        <style>\n" +
                          "            body{\n" +
                          "                font-family: Arial, Helvetica, sans-serif;\n" +
                          "                color: navy;\n" +
                          "                background-color: rgb(242, 254, 250);\n" +
                          "            }\n" +
                          "            #title{\n" +
                          "                margin-top: 3%;\n" +
                          "                text-align: center;\n" +
                          "            }\n" +
                          "            .dogflex{\n" +
                          "                display: flex;\n" +
                          "                flex-direction: row;\n" +
                          "            }\n" +
                          "            .dog{\n" +
                          "                padding: 1%;\n" +
                          "                margin-left: 10%;\n" +
                          "                margin-top: 3%;\n" +
                          "                color: rgb(41, 41, 158);\n" +
                          "                background-color: rgb(205, 247, 233);\n" +
                          "                padding-bottom: 1%;\n" +
                          "                text-align: center;\n" +
                          "            }\n" +
                          "            img{\n" +
                          "                width: 250px;\n" +
                          "                height: 300px;\n" +
                          "            }\n" +
                          "        </style>\n" +
                          "        <h1 id=\"title\">List of Dogs Available</h1>\n" +
                          "        <div class=\"dogflex\">";
         int count=0;
         for(int i=0;i<ld.size();i++){
             doghtml= doghtml + "<div class=\"dog\">\n";
             String breed = ld.get(i).getBreed();
             String image = ld.get(i).getImage();
             doghtml= doghtml + "<img src=" + image + "\n" +
                      "> <h3>" + breed +
                      "</h3>\n" +
                      "</div>\n";
             count++;
             if(count==3){
                 doghtml= doghtml + "</div>\n" +
                          "<div class=\"dogflex\">";
                 count=0;
             }
         }
         doghtml= doghtml + "</body>\n" +
                  "</html>\n";
         return doghtml;
     }

     @GetMapping("/getcat")
     public String getDetailsCats(){
         List<Petproject> lc = pprepo.findByType("cat");
         String cathtml = "<html>\n" +
                          "    <body>\n" +
                          "        <style>\n" +
                          "            body{\n" +
                          "                font-family: Arial, Helvetica, sans-serif;\n" +
                          "                color: navy;\n" +
                          "                background-color: rgb(242, 254, 250);\n" +
                          "            }\n" +
                          "            #title{\n" +
                          "                margin-top: 3%;\n" +
                          "                text-align: center;\n" +
                          "            }\n" +
                          "            .catflex{\n" +
                          "                display: flex;\n" +
                          "                flex-direction: row;\n" +
                          "            }\n" +
                          "            .cat{\n" +
                          "                padding: 1%;\n" +
                          "                margin-left: 10%;\n" +
                          "                margin-top: 3%;\n" +
                          "                color: rgb(41, 41, 158);\n" +
                          "                background-color: rgb(205, 247, 233);\n" +
                          "                padding-bottom: 1%;\n" +
                          "                text-align: center;\n" +
                          "            }\n" +
                          "            img{\n" +
                          "                width: 250px;\n" +
                          "                height: 300px;\n" +
                          "            }\n" +
                          "        </style>\n" +
                          "        <h1 id=\"title\">List of Cats Available</h1>\n" +
                          "        <div class=\"catflex\">";
         int count=0;
         for(int i=0;i<lc.size();i++){
             cathtml= cathtml + "<div class=\"cat\">\n";
             String image = lc.get(i).getImage();
             String breed = lc.get(i).getBreed();
             cathtml= cathtml + "<img src=" + image + "\n" +
                      "> <h3>" + breed +

                      "</h3>\n" +
                      "</div>\n";
             count++;
             if(count==3){
                 cathtml= cathtml + "</div>\n" +
                          "<div class=\"catflex\">";
                 count=0;
             }
         }
         cathtml= cathtml + "</body>\n" +
                  "</html>\n";
         return cathtml;
     }
    
     @GetMapping("/getfish")
     public String getDetailsFishes(){
         List<Petproject> lf = pprepo.findByType("fish");
         String fishhtml = "<html>\n" +
                           "    <body>\n" +
                           "        <style>\n" +
                           "            body{\n" +
                           "                font-family: Arial, Helvetica, sans-serif;\n" +
                           "                color: navy;\n" +
                           "                background-color: rgb(242, 254, 250);\n" +
                           "            }\n" +
                           "            #title{\n" +
                           "                margin-top: 3%;\n" +
                           "                text-align: center;\n" +
                           "            }\n" +
                           "            .fishflex{\n" +
                           "                display: flex;\n" +
                           "                flex-direction: row;\n" +
                           "            }\n" +
                           "            .fish{\n" +
                           "                padding: 1%;\n" +
                           "                margin-left: 10%;\n" +
                           "                margin-top: 3%;\n" +
                           "                color: rgb(41, 41, 158);\n" +
                           "                background-color: rgb(205, 247, 233);\n" +
                           "                padding-bottom: 1%;\n" +
                           "                text-align: center;\n" +
                           "            }\n" +
                           "            img{\n" +
                           "                width: 250px;\n" +
                           "                height: 300px;\n" +
                           "            }\n" +
                           "        </style>\n" +
                           "        <h1 id=\"title\">List of Fishes Available</h1>\n" +
                           "        <div class=\"fishflex\">";
         int count=0;
         for(int i=0;i<lf.size();i++){
             fishhtml= fishhtml + "<div class=\"fish\">\n";
             String breed = lf.get(i).getBreed();
             String image = lf.get(i).getImage();
             fishhtml= fishhtml + "<img src=" + image + "\n" +
                       "> <h3>" + breed +

                       "</h3>\n" +
                       "</div>\n";
             count++;
             if(count==3){
                 fishhtml= fishhtml + "</div>\n" +
                           "<div class=\"fishflex\">";
                 count=0;
             }
         }
         fishhtml= fishhtml + "</body>\n" +
                   "</html>\n";
         return fishhtml;
     }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable String Id) {
        pprepo.deleteById(Id);
    }

    @GetMapping("/getdogslist")
    public List<Petproject> getdogslist() {
        return pprepo.findByType("dog");
    }

    @GetMapping("/getcatslist")
    public List<Petproject> getcatslist() {
        return pprepo.findByType("cat");
    }

    @GetMapping("/getfisheslist")
    public List<Petproject> getfisheslist() {
        return pprepo.findByType("fish");
    }
    
}


