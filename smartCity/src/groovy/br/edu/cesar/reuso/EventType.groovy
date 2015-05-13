package br.edu.cesar.reuso

/**
 * Created by Aercio Melo on 3/31/15.
 *
 * Arborização (poda de árvore)
 * Drenagem (desentupimento de galeria)
 * Iluminação Pública (poste com lâmpada queimada)
 * Limpeza Urbana (denúncia de lixo irregular)
 * Pavimentação (denúncia de buraco em via)
 */
enum EventType {
    TREES('Arborização'),
    SEWER('Drenagem'),
    LIGHTING('Iluminação Pública'),
    TRASH('Limpeza Urbana'),
    PAVING('Pavimentação')

    // Constructor to set the Status name
    EventType(String name) {
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
