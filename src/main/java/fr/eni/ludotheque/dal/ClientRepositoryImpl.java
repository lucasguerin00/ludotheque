package fr.eni.ludotheque.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Client;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static int idxClient = 1;
    private List<Client> clients;

    public ClientRepositoryImpl() {
        clients = new ArrayList<>();
        clients.add(new Client(idxClient++, "Dupont", "Pierre", "pierre.dupont@example.com", "0102030405", "12 Rue de Paris", "75001", "Paris"));
        clients.add(new Client(idxClient++, "Lemoine", "Sophie", "sophie.lemoine@example.com", "0607080910", "34 Avenue de la République", "69002", "Lyon"));
        clients.add(new Client(idxClient++, "Martin", "Luc", "luc.martin@example.com", "0112233445", "56 Boulevard Saint-Germain", "75005", "Paris"));
        clients.add(new Client(idxClient++, "Bernard", "Claire", "claire.bernard@example.com", "0708091011", "78 Rue de la Liberté", "13001", "Marseille"));
        clients.add(new Client(idxClient++, "Giraud", "Michel", "michel.giraud@example.com", "0123456789", "90 Rue des Lilas", "44000", "Nantes"));
        clients.add(new Client(idxClient++, "Durand", "Julie", "julie.durand@example.com", "0654321098", "101 Rue de la Paix", "33000", "Bordeaux"));
        clients.add(new Client(idxClient++, "Blanc", "Jacques", "jacques.blanc@example.com", "0134567890", "23 Boulevard de la Croisette", "06400", "Cannes"));
        clients.add(new Client(idxClient++, "Leclerc", "Alice", "alice.leclerc@example.com", "0789456123", "45 Route de Toulouse", "31000", "Toulouse"));
        clients.add(new Client(idxClient++, "Pires", "David", "david.pires@example.com", "0601020304", "67 Avenue de la Gare", "21000", "Dijon"));
        clients.add(new Client(idxClient++, "Roux", "Emilie", "emilie.roux@example.com", "0612345678", "89 Rue des Fleurs", "35000", "Rennes"));
    }

    @Override
    public void add(Client client) {
        idxClient++;
        client.setNoClient(idxClient);
        System.out.println(client);
        this.clients.add(client);
    }

    @Override
    public List<Client> getAll() {
        return clients.stream().collect(Collectors.toList());
    }

    @Override
    public  Optional<Client> getById(int id) {
        return this.clients.stream().filter(c ->  c.getNoClient() == id).findFirst();
    }

    public void update(Client client) {
        Optional<Client> oldClientOptional = getById(client.getNoClient());
        if (oldClientOptional.isPresent()) {
        	
            Client oldClient = oldClientOptional.get();
            BeanUtils.copyProperties(client, oldClient);
            /*
            oldClient.setNom(client.getNom());
            oldClient.setPrenom(client.getPrenom());
            oldClient.setRue(client.getRue());
            oldClient.setCodePostal(client.getCodePostal());
            oldClient.setVille(client.getVille());
            oldClient.setEmail(client.getEmail());
            oldClient.setNoTelephone(client.getNoTelephone());
            */
        }
    }

    public void delete(int id) {
        Optional<Client> clientOptional = getById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
           clients.remove(client);
        }
    }

	
}
