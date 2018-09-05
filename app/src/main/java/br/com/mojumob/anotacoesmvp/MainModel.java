package br.com.mojumob.anotacoesmvp;

class MainModel implements MainMVP.ModelOps {

    //Referencia para layer Presenter
    private MainMVP.RequiredPresenterOps mPresenter;

    public MainModel(MainPresenter mainPresenter) {
    }


    //Insere nota no BD
    @Override
    public void insereNota(Nota nota) {
        //Logica para inserir no BD
    }


    //remove nota do BD
    @Override
    public void removeNota(Nota nota) {
        //Logica para remover a nota do BD
        //...
        mPresenter.onNotaInserida(nota);
    }

    /*
     * Disparado pelo MainPresenter#onDestroy para as operações
     * necessárias que eventualmente estiverem executadas no BG
     * */
    @Override
    public void onDestroy() {

    }
}
