import java.util.ArrayList;

public class DominoPile {
    //properties
    private ArrayList<Domino> pile;

    //constructor
    public DominoPile(){
        this.pile = new ArrayList<>();
    }

    //methods
    public ArrayList<Domino> getPile(){
        return pile;
    }
    public void newStack6(){
        //nested for loop to create 0,1 and no 1,0
        for (int i = 0; i <= 6; i++){
            for (int j = i; j <= 6; j++){
                Domino domino = new Domino(i, j);
                this.pile.add(domino);
            }
        }
    }
    public void shuffleOptionOne(){
        ArrayList<Domino> newPile = new ArrayList<>();
        //copyPile is to remove elements that have already been added to newPile,
        //without affecting this.pile
        ArrayList<Domino> copyPile = this.pile;

        //slowly delete elements from the copy pile, and add it to new pile,
        //based on randomly generated integers
        //account for small probability test fails because random new pile is the same as previous
        do {
            while (copyPile.size() > 0){
                int randomIndex = (int) Math.floor(Math.random() * copyPile.size());
                newPile.add(copyPile.get(randomIndex));
                copyPile.remove(randomIndex);
            }
        }while (newPile.equals(this.pile));

        this.pile = newPile;
    }
}
