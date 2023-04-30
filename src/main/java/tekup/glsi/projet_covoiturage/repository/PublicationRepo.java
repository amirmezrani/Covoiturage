package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Publication;

import java.time.LocalDateTime;
import java.util.List;

public interface PublicationRepo extends JpaRepository<Publication, Long> {

    List<Publication> findByDateDepartAfter(LocalDateTime departTimeAfter);

    List<Publication> findAllByConducteur_Id(Long id);

}
