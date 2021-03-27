package infama.interview.question1.urlshortener.doa;


import infama.interview.question1.urlshortener.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<UrlModel,Long> {
    UrlModel getUrlModelById(Long id);
    UrlModel findFirstByUrl(String url);
}
