
package br.edu.ifpb.pos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 01/11/2017
 */

public class PessoaService {

    private Set<Pessoa> pessoas = new HashSet<>();

    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
    
    public Iterator<Pessoa> todasAsPessoas() {
        return pessoas.iterator();
    }
    
}
