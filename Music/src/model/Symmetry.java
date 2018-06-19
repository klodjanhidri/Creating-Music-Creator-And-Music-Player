
package model;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Panagiotis Papadakos <papadako@gmail.com>
 */
interface Symmetry {
    
    public void doNothing() throws SymmetryActionOnNonValidAtonalRow;
    public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow;
    public void retrograde() throws SymmetryActionOnNonValidAtonalRow;
    public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow;
    
}
