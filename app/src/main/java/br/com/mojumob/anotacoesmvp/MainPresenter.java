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

    /*
    * Disparado por Activity após a mundança de configurtação
    * @param view Referência para a view
    * */
    @Override
    public void onConfigurationChanged(MainMVP.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }


    /*
    * Recebe o evento {@link MainActivity#onDestroy}
    * @param isChangingConfig se está mudando de config
    * */
    @Override
    public void onDestroy(boolean isChangingConfig) {
        mView = null;
        mIsChagingConfig = isChangingConfig;
        if(!isChangingConfig){
            mModel.onDestroy();
        }
    }

    /*
    * Chamado pelo MainActivity quando o usuario pedi uma nova nota
    * */
    @Override
    public void novaNota(String textoNota) {
        Nota nota = new Nota();
        nota.setText(textoNota);
        nota.setDate(getDate());
        mModel.insereNota(nota);
    }

    /*
    * Chamado pelo MainActivity para a remoção da nota
    * */
    @Override
    public void deletaNota(Nota nota) {
        mModel.removeNota(nota);
    }

    /*
    * Recebe o pedido do MainModel quando a nota for inserida com sucesso no BD
    * */
    @Override
    public void onNotaInserida(Nota novaNota) {
        mView.get().showToast("Novo Registro " + novaNota.getDate());
    }

    /*
    * Recebe o chamado do MainModel quando a nota for removida do BD
    * */
    @Override
    public void onNotaRemovida(Nota notaRemovida) {
        mView.get().showToast("Nota de " + notaRemovida.getDate() + " removida");
    }

    /*
    * Recebe eventuais erros do modelo e repassa a msg para o usuario
    * */
    @Override
    public void onError(String errorMsg) {
        mView.get().showAlert(errorMsg);
    }

    /*Retorna a data atual*/
    private String getDate(){
        String hoje = "hoje";
        return hoje;
    }
}
