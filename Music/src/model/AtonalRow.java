

package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfugue.*;
import view.AtonalView;
/*
 * To change this template, choose T
 * 
 * ools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klodjan Hidri
 * @author Evagelia Petavraki
 */
public class AtonalRow implements Symmetry {

    int s1 = 1;
    private File filenotes = new File("");
    
    private static String outputFile;
    public String init12notes, ss, notes;
    public static ArrayList<String> actions = new ArrayList(), b = new ArrayList(), bb = new ArrayList(),
            bbb = new ArrayList(), rows = new ArrayList();

    public AtonalRow() {
    }

    /**
     * Kataskeuastria methodo gia thn dimiourgeia enos atonalrow me 12 arxikes
     * notes ,organo ,sunthetis ,kai to eidos mousikis algorithmic ,atonal h
     * free
     *
     * @param init12notes
     * @param instrument
     * @param composer
     * @param mode
     */
    public AtonalRow(String init12notes, String instrument, String composer, String mode) {
    }

    /**
     * epilogi ths seiras twn 12 notwn pou epelekse o xristis apo to ksilofono
     *
     * @param init12notes
     */
    public void setInit12Notes(String init12notes) {
        if (this.init12notes == null) {
            this.init12notes = init12notes;
        } else {
            this.init12notes += init12notes;
        }

    }

    /**
     * epistrofi ths seiras twn 12 notwn pou epelekse o xristis apo to ksilofono
     *
     * @return init12notes
     */
    public String getInit12Notes() {
        return this.init12notes;
    }

    /**
     * topotthetisi twn 12 notwn se ena arxio gia na gunei h epeksergasia tous
     * analoga me tis energies pou exei epileksei o xristis
     */
    public void addInit12NotesInFile() {
        System.out.println(this.actions);
        this.init12notes += this.init12notes;
        System.out.println(this.init12notes + " LLL");

    }

    /**
     * topothetisi me tin seira twn energiwn pou exei patisei o xristis apo to
     * UI se ena arraylist
     *
     * @param actions
     * @return actions
     */
    public void setActions(String actions) {
        this.actions.add(actions);

    }

    public ArrayList<String> getActions() {
        return this.actions;

    }

    /**
     * diplasiasmos twn notwn xoris na kanoume kamia energia panw tous
     *
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void setRows(String row) {
        this.rows.add(row);
    }

    public  ArrayList<String> getRows() {
        System.out.println(this.getActions());
        return this.rows;
    }

    public void doNothing() throws SymmetryActionOnNonValidAtonalRow {

          notes = this.init12notes;
          this.setRows(notes);
       
    }

    /**
     * diplasiasmos twn notwn kanontas shift kata x
     *
     * @param x
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
        this.inverse();
        String init12note = null;
        int siz = this.b.size();
        int f = 2 * x;
        for (int i = 2 * x; i > 0; i--) {
            if (i == f) {
                if (this.b.get(f).contentEquals(" ")) {
                    i--;
                }
            }
            if (init12note == null) {
                init12note = this.b.get(i);
            } else {
                init12note += this.b.get(i);
            }

        }
        for (int j = b.size() - 1; j > 2 * x; j--) {
            if (j == f + 1) {
                if (init12note == null) {
                    init12note = this.b.get(j) + " ";
                } else {
                    init12note += this.b.get(j) + " ";
                }

                j--;
            } else {
                init12note += this.b.get(j);

            }

        }
        this.setRows(init12note);
        this.bb.clear();
        b.clear();
        System.out.println(init12note + "trans");

    }

    public void inverse() {
        for (int i = this.init12notes.length() - 1; i >= 0; i--) {
            this.bb.add(this.init12notes.charAt(i) + "");
        }
        for (int j = 0; j <= this.bb.size() - 1; j++) {
            if (this.bb.get(j).equalsIgnoreCase("#")) {
                this.b.add(this.bb.get(j + 1) + "#");
                j++;

            } else if (!this.bb.get(j).equalsIgnoreCase("#")) {
                this.b.add(this.bb.get(j) + "");
            }
        }
        b.add(" ");
    }

    /**
     * diplasiasmos twn notwn grafontas tous anapoda
     *
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
        String init12note = null;
        for (int i = this.init12notes.length() - 2; i >= 0; i--) {
            if (i == 0) {
                if (init12note == null)
                {
                    init12note = this.init12notes.charAt(i) + " ";
                } else {
                    init12note += this.init12notes.charAt(i) + " ";
                }
                break;

            }
            if (this.init12notes.charAt(i) == '#') {
                if (init12note == null) {
                    init12note = this.init12notes.charAt(i - 1) + "";
                } else {
                    init12note += this.init12notes.charAt(i - 1) + "";
                }

                i--;
                init12note += "#";
            } else if (this.init12notes.charAt(i) != '#') {
                if (init12note == null) {
                    init12note = this.init12notes.charAt(i) + "";
                } else {
                    init12note += this.init12notes.charAt(i) + "";
                }
            }
        }
        // this.init12notes += " ";
        this.setRows(init12note);
        System.out.println(init12note + "Retr");

    }

    /**
     * diplasiasmos twn notwn kanontas reflect kata x
     *
     * @param x
     * @throws SymmetryActionOnNonValidAtonalRow
     */
    public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
        ArrayList<String> b1 = new ArrayList(), b2 = new ArrayList(), b3 = new ArrayList();
        String init12note = null;
        this.inverse();


        for (int i = this.b.size() - 1; i >= 0; i--) {
            if (i == this.b.size() - 1) {
                if (this.b.get(i).equalsIgnoreCase(" ")) {
                    this.bbb.add(this.b.get(i - 1));
                    i--;
                }
            } else {
                this.bbb.add(this.b.get(i));
            }
        }
        System.out.println(bbb);
        /*----------------------------------------------------------------------------*/
        System.out.println(x);
        int size = this.bbb.size();
        int ff = 2 * x;
        int kk = size / 2;
        int tmp = (ff + kk) % size;

        this.b.clear();
        this.bb.clear();

//------------------------------------------------------------------------------
        if (ff < kk) {


            for (int j = ff; j <= kk + ff; j++) {
                if (j == ff) {
                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j + 1));
                    j++;
                    // j++;
                } else if (j == (kk + ff)) {

                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j + 1));
                    // j++;

                } else if (j > ff && j < kk + ff) {
                    b2.add(this.bbb.get(j));

                }
            }
            System.out.println(b1 + "b1");
            System.out.println(b2 + "b2");
            for (int ii = kk + ff + 2; ii <= size - 1; ii++) {

                b3.add(this.bbb.get(ii));

            }

            for (int z = 0; z < ff; z++) {
                b3.add(this.bbb.get(z));
            }
            System.out.println(b3 + "b3");

            for (int jj = 0; jj <= size - 1; jj++) {
                if (jj == 0) {
                    if (init12note == null) {
                        init12note = b1.get(0);
                        init12note += b1.get(1);
                    }
                } else if (jj == (size / 2 + ff)) {
                    if (init12note == null) {
                        init12note = b1.get(2);
                        init12note = b1.get(3);
                    } else {
                        init12note += b1.get(2);
                        init12note += b1.get(3);

                    }
                } else if (jj > 0 && jj != size / 2 + ff) {
                    if (jj <= kk && jj < b3.size()) {
                        if (jj == 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        } else if (jj > 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        }
                    }
                }
                //if (jj == size / 2 + ff + 1)
                for (int ll = 1; ll < b2.size(); ll++) {
                    if (jj == size / 2 + ff + 1) {
                        if (init12note == null) {
                            init12note = b2.get(b2.size() - 1 - ll);
                            init12note = b2.get(b2.size() - ll);
                        } else {
                            init12note += b2.get(b2.size() - 1 - ll);
                            init12note += b2.get(b2.size() - ll);
                        }

                        ll++;
                    }
                }
            }

            this.setRows(init12note);
            b1.clear();
            b2.clear();
            b3.clear();
            bbb.clear();

            System.out.println(init12note + "refle");

        }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (ff > kk) {

            //for (int j = tmp; j <=ff; j++)
            for (int j = bbb.size() - 1; j >= 0; j--) {
                if (j == ff) {
                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j - 1));
                    j--;
                    // j++;
                } else if (j == tmp) {

                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j - 1));
                    // j++;

                } else if (j < ff && j > tmp) {
                    b2.add(this.bbb.get(j));

                }
            }
            System.out.println(b1 + "b1");
            System.out.println(b2 + "b2");

            for (int ii = tmp - 2; ii >= 0; ii--) {
                if (ii == 0) {
                    b3.add(this.bbb.get(ii));
                    // b3.add(" ");

                } else {
                    b3.add(this.bbb.get(ii));
                }

            }

            for (int z = this.bbb.size() - 1; z > ff; z--) {
                b3.add(this.bbb.get(z));
            }

            System.out.println(b3 + "b3");


            for (int jj = 0; jj <= size - 1; jj++) {
                if (jj == 0) {
                    if (init12note == null) {
                        init12note = b1.get(0);
                        init12note += b1.get(1);
                    }
                } else if (jj == (size / 2 + ff)) {
                    if (init12note == null) {
                        init12note = b1.get(2);
                        init12note = b1.get(3);
                    } else {
                        init12note += b1.get(2);
                        init12note += b1.get(3);

                    }
                } else if (jj > 0 && jj != size / 2 + ff) {
                    if (jj <= kk && jj < b3.size()) {
                        if (jj == 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        } else if (jj > 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        }
                    }
                }
                //if (jj == size / 2 + ff + 1)
                for (int ll = 1; ll < b2.size(); ll++) {
                    if (jj == size / 2 + ff + 1) {
                        if (init12note == null) {
                            init12note = b2.get(b2.size() - 1 - ll);
                            init12note = b2.get(b2.size() - ll);
                        } else {
                            init12note += b2.get(b2.size() - 1 - ll);
                            init12note += b2.get(b2.size() - ll);
                        }

                        ll++;
                    }
                }
            }
            
            
            for (int zz = 1; zz <= b2.size() - 1; zz++) {
                init12note += b2.get(b2.size() - 1 - zz);
                init12note += b2.get(b2.size() - zz);

                zz++;
            }
            this.setRows(init12note);
            b1.clear();
            b2.clear();
            b3.clear();
            bbb.clear();
        }

//============================================================================
        if (ff == kk) {
            for (int j = bbb.size() - 1; j >= 0; j--) {
                if (j == ff) {
                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j + 1));
                    j--;
                    // j++;
                } else if (j == tmp) {

                    b1.add(this.bbb.get(j));
                    b1.add(this.bbb.get(j + 1));
                    // j++;

                } else if (j < ff && j > tmp) {
                    b2.add(this.bbb.get(j));

                } else if (j > ff && j < bbb.size() - 1) {
                    b3.add(this.bbb.get(j));
                }
            }
            System.out.println(b1 + "b1");
            System.out.println(b2 + "b2");
            System.out.println(b3 + "b3");

            for (int jj = 0; jj <= size - 1; jj++) {
                if (jj == 0) {
                    if (init12note == null) {
                        init12note = b1.get(0);
                        init12note += b1.get(1);
                    }
                } else if (jj == (size / 2 + ff)) {
                    if (init12note == null) {
                        init12note = b1.get(2);
                        init12note = b1.get(3);
                    } else {
                        init12note += b1.get(2);
                        init12note += b1.get(3);

                    }
                } else if (jj > 0 && jj != size / 2 + ff) {
                    if (jj <= kk && jj < b3.size()) {
                        if (jj == 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        } else if (jj > 1) {
                            if (init12note == null) {
                                init12note = b3.get(b3.size() - 1 - jj);
                                init12note = b3.get(b3.size() - jj);
                            } else {
                                init12note += b3.get(b3.size() - 1 - jj);
                                init12note += b3.get(b3.size() - jj);
                            }
                            jj++;
                        }
                    }
                }
                //if (jj == size / 2 + ff + 1)
                for (int ll = 1; ll < b2.size(); ll++) {
                    if (jj == size / 2 + ff + 1) {
                        if (init12note == null) {
                            init12note = b2.get(b2.size() - 1 - ll);
                            init12note = b2.get(b2.size() - ll);
                        } else {
                            init12note += b2.get(b2.size() - 1 - ll);
                            init12note += b2.get(b2.size() - ll);
                        }

                        ll++;
                    }
                }
            }
            for (int zz = 1; zz <= b2.size() - 1; zz++) {
                init12note += b2.get(b2.size() - 1 - zz);
               init12note += b2.get(b2.size() - zz);

                zz++;
            }
            this.setRows(init12note);
            b1.clear();
            b2.clear();
            b3.clear();
            bbb.clear();
        }
//------------------------------------------------------------------------------

//-----------------------------------------------------------------------------
        System.out.println(this.init12notes + "init");
    }

   
}
