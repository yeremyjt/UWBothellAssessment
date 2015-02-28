package org.yeremy;
/**
 * TrinaryMoutainFactory
 *
 * 	Offers a small tree with 0-3 children per node.
 *
 * 	This is useful for testing the generality of your WumpusHunter
 * 	solution. Creates a small set of caves.
 *
 */


public class MyMountainFactory extends MountainFactory {

    @Override
	public MountainCave getMountainTop() {
	MountainCave root = new MountainCave("Mountain Top","The air density here seems to indicate you're not far from the base of the mountain");

	MountainCave r5 = new MountainCave(root, "Sand Dust", "This cave has lots of sand. Be careful");		//leaf
	MountainCave r4 = new MountainCave(root, "Harry Potter's Cave", "This cave was previously owned by Harry Potter");		//leaf
	MountainCave r3 = new MountainCave(root, "Fox Den", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r2 = new MountainCave(root,"Dragon's Alley", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r1 = new MountainCave(root, "Craggy Cliff", "This small passage makes it difficult to see ahead");

	MountainCave r11 = new MountainCave(r1,"Sword Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r12 = new MountainCave(r1,"Shield Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r13 = new MountainCave(r1,"Helm Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r14 = new MountainCave(r1,"Breast Plate Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r15 = new MountainCave(r1,"Helmet Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf

	MountainCave r21 = new MountainCave(r2,"Thief's Pass", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r22 = new MountainCave(r2,"Warrior's Way", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r23 = new MountainCave(r2,"Priest's Path", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r24 = new MountainCave(r2,"Holy Path", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r25 = new MountainCave(r2,"Cavern's Path", "This cave has huge rocks covered in multi-leaf clovers");		//leaf

	MountainCave r31 = new MountainCave(r3,"Gem Mine", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r32 = new MountainCave(r3,"Alabaster Room", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r33 = new MountainCave(r3,"Underground River", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r34 = new MountainCave(r3,"Overground River", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r35 = new MountainCave(r3,"Barren River", "This cave has huge rocks covered in multi-leaf clovers");		//leaf

	MountainCave r41 = new MountainCave(r4,"Lonely Hall", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r42 = new MountainCave(r4,"Scary Hall", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r43 = new MountainCave(r4,"Enchanted Hall", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r44 = new MountainCave(r4,"Boring Hall", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r45 = new MountainCave(r4,"Scary Movie Hall", "This cave has huge rocks covered in multi-leaf clovers");		//leaf

	MountainCave r51 = new MountainCave(r5,"Death's Place", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r52 = new MountainCave(r5,"Satan's Place", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r53 = new MountainCave(r5,"Cold Place", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r54 = new MountainCave(r5,"Black Death's Place", "This cave has huge rocks covered in multi-leaf clovers");		//leaf
	MountainCave r55 = new MountainCave(r5,"Smells like Rat's Place", "This cave has huge rocks covered in multi-leaf clovers");		//leaf

	MountainCave r551 = new MountainCave(r55,"Treasure Room", "The golden scales are here!");	//leaf

	r55.setAdjacentToScales(true);
	r551.setHasScales(true);

	return root;
    }

}
