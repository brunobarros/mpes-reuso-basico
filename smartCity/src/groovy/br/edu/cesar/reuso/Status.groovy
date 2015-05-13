package br.edu.cesar.reuso

/**
 * Created by Aercio Melo on 3/31/15.
 */
enum Status {
    O('Em Aberto'),
    P('Em Andamento'),
    F('Concluído')

    // Constructor to set the Status name
    Status(String name) {
        this.name = name
    }

    final String name

    @Override
    String toString() {
        name
    }

    String getKey() {
        name()
    }
}
