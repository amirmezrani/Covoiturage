package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.service.PublicationService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/publication/")
public class PublicationController {

    private PublicationService publicationService;



   @GetMapping
   public List<Publication> getAllPublication(){
        return publicationService.getAllPublication();
    }

    @GetMapping("{id}")
    public Publication getPublicationById (@PathVariable Long id){
        return  publicationService.getPublicationById(id);
    }


    @GetMapping("conducteur/{id}")
    public List<Publication> getAllConducteurPublication(@PathVariable Long id){
        return publicationService.getAllConducteurPublication(id);
    }

    @GetMapping("recherche")
    public List<Publication> getAllPublicationDispoLieu(@RequestParam String lieuD,
                                                        @RequestParam String lieuA) {

        return publicationService.getAllPublicationDispoLieu(lieuD, lieuA);
    }

    @GetMapping("disponible")
    public List<Publication> getAllPublicationDispo(){
        return publicationService.getAllPublicationDispo();
    }



    @PostMapping("conducteur/{id}")
    public Publication addPublication(@PathVariable Long id,@RequestBody Publication publication){

        return publicationService.addPublication(id,publication);
    }

    @PutMapping("{id}")
    public Publication editPublication(@PathVariable Long id ,@RequestBody Publication publication){

        return publicationService.editPublication(id,publication);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePublication (@PathVariable Long id){

        return publicationService.deletePublication(id);
    }

}
