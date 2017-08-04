package pl.com.bottega.gameoflife;

interface GameOfLife {

    // tworzy nowa plansze do gry o zadanej szerokosci i wysokosci, wszystkie komórki są martwe
    void init(int w, int h);

    // ustawia stan komórki o współrzędnych (x, y) na żywą bądź martwą w zal. od parametru alive
    void updateCell(int x, int y, boolean alive);

    // zwraca informacje czy komórka o współrzędnych (x,y) jest żywa czy martwa
    boolean cellState(int x, int y);

    // oblicza nowy stan gry na podstawie stanu bieżącego
    void next();

}
