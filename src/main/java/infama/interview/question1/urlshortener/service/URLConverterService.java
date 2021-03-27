package infama.interview.question1.urlshortener.service;

import infama.interview.question1.urlshortener.models.UrlModel;
import infama.interview.question1.urlshortener.doa.URLRepository;
import infama.interview.question1.urlshortener.utility.DBUrlIdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLConverterService {

    private final URLRepository urlRepository;

    @Autowired
    public URLConverterService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenURL(String localURL, String longUrl) {
        UrlModel urlModel= urlRepository.findFirstByUrl(longUrl);
        if(urlModel==null) {
            urlModel = new UrlModel();
            urlModel.setUrl(longUrl);
        }

        UrlModel model = urlRepository.save(urlModel);
        String uniqueID = DBUrlIdConverter.getInstance().createUniqueID(model.getId());
        String baseString = formatLocalURLFromShortener(localURL);
        return baseString + uniqueID;
    }

    public String getLongURLFromID(String uniqueID) {
        Long dictionaryKey = DBUrlIdConverter.getInstance().getDictionaryKeyFromUniqueID(uniqueID);
        UrlModel urlModel = urlRepository.getUrlModelById(dictionaryKey);
        return urlModel.getUrl();
    }

    private String formatLocalURLFromShortener(String localURL) {
        String[] addressComponents = localURL.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addressComponents.length - 1; ++i) {
            sb.append(addressComponents[i]);
        }
        sb.append('/');
        return sb.toString();
    }

}
