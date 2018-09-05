package br.com.mojumob.anotacoesmvp;

public interface MainMVP {


    //Metodos obrigatorios em View, disponivel para o Presenter: Presenter -> View
    interface RequiredViewOps{
        void showToast(String msg);
        void showAlert(String msg);
    }

    //Operaçoes a View para comunicação com o Presenter: View->Presenter
    interface PresenterOps{
        void onConfigurationChanged(RequiredViewOps view);
        void onDestroy (boolean isChangingConfig);
        void novaNota(String textoNota);
        void deletaNota(Nota nota);
    }


    //Operações do Model para comunicação com o Presenter: Model -> Presenter
    interface RequiredPresenterOps{
        void onNotaInserida(Nota novaNota);
        void onNotaRemovida(Nota notaRemovida);
        void onError(String errorMsg);
    }

    //Operações do Model para o Presenter: Presenter -> Model
    interface ModelOps{
        void insereNota(Nota nota);
        void removeNota(Nota nota);
        void onDestroy();
    }

}
