package tekup.glsi.projet_covoiturage.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Demande;
import tekup.glsi.projet_covoiturage.model.Passager;
import tekup.glsi.projet_covoiturage.repository.DemandeRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class DemandeService {

    private DemandeRepo demandeRepo;
    private PassagerService passagerService;
    private ConducteurService conducteurService;
    private PublicationService publicationService;



    public Demande getDemandeById (Long id){
        return  demandeRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Demande ID not Found"));
    }



    public List<Demande> getAllDemande(){
        return demandeRepo.findAll();
    }

    public Demande addDemande(Demande demande){
        return demandeRepo.save(demande);
    }

    public Demande accepterDemande(Long id){

        Demande demande =getDemandeById(id);
        demande.setReponse("true");

        return demandeRepo.save(demande);

    }

    public Demande rejeterDemande(Long id){

        Demande demande =getDemandeById(id);
        demande.setReponse("false");

        return demandeRepo.save(demande);
    }

    public List<Demande> getAllAcceptersPassager(Long id){

        List<Demande> demandes=demandeRepo.findByPassager_IdAndAndReponse(id,"true");
        return demandes;

    }

    public List<Demande> getAllRejeterPassager(Long id){

        List<Demande> demandes=demandeRepo.findByPassager_IdAndAndReponse(id,"false");
        return demandes;

    }


    public ResponseEntity<?> deleteDemande (Long id){
        demandeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
