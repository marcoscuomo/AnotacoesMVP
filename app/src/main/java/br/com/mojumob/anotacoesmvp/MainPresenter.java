package br.com.mojumob.anotacoesmvp;

import java.lang.ref.WeakReference;

public class MainPresenter implements MainMVP.RequiredPresenterOps, MainMVP.PresenterOps{


    //Referência para a layer view
    private WeakReference<MainMVP.RequiredViewOps> mView;

    //Referência para o layer model
    private MainMVP.ModelOps mModel;

    //Estado de mudança da configuração
    private boolean mIsChagingConfig;

    //Construtor
    public MainPresenter(MainMVP.RequiredViewOps mView){
        this.mView = new WeakReference<>(mView);
        this.mModel = new MainModel(this);
    }

    @Override
    public void onConfigurationChanged(MainMVP.RequiredViewOps view) {

    }

    @Override
    public void onDestroy(boolean isChangingConfig) {

    }

    @Override
    public void novaNota(String textoNota) {

    }

    @Override
    public void deletaNota(Nota nota) {

    }

    @Override
    public void onNotaInserida(Nota novaNota) {

    }

    @Override
    public void onNotaRemovida(Nota notaRemovida) {

    }

    @Override
    public void onError(String errorMsg) {

    }
}
