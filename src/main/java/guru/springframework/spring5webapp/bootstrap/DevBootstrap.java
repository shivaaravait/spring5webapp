package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		initData();
	}

	private void initData() {
		
		Publisher hcPublisher = new Publisher();
		hcPublisher.setName("Harper Collins");
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", hcPublisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		publisherRepository.save(hcPublisher);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		

		Publisher worxPublisher = new Publisher();
		worxPublisher.setName("Worx");
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", worxPublisher);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		publisherRepository.save(worxPublisher);
		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}
}
