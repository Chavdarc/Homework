package warehouse;

public class Demo {

	public static void main(String[] args) {

		Warehouse pazar = new Warehouse();
		Supplier supplify = new Supplier("Bate gosho", pazar);
		Store denonoshnoto = new Store("denonoshnoto", pazar);
		Store billa = new Store("Billa", pazar);
		Store butka = new Store("Butka", pazar);
		
		Client ver = new Client("Veronique", denonoshnoto);
		Client jz = new Client("JZ", denonoshnoto);
		Client bionce = new Client("Bionce", denonoshnoto);
		
		Client leBastardoOne = new Client("Don Diego", billa);
		Client leBastardoTwo = new Client("Jose", billa);
		Client leBastardoÒhðåå = new Client("Julio the Gun", billa);
		
		Client baiIvan = new Client("Bai Ivan", butka);
		Client kakaGinche = new Client("Prosto Ginche", butka);
		Client mimiSasedkatata = new Client("Mimi", butka);
		
		denonoshnoto.start();
		ver.start();
		jz.start();
		bionce.start();
		supplify.start();
		billa.start();
		leBastardoOne.start();
		leBastardoTwo.start();
		leBastardoÒhðåå.start();
		butka.start();
		baiIvan.start();
		kakaGinche.start();
		mimiSasedkatata.start();
	}

}
