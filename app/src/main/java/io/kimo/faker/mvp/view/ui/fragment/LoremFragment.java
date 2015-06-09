package io.kimo.faker.mvp.view.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.presenter.LoremPresenter;
import io.kimo.faker.mvp.BaseView;

public class LoremFragment extends BaseView implements io.kimo.faker.mvp.view.LoremView {

    private View mainView, loadingView;
    private TextView character, characters, word, words, sentence, sentences, paragraph, paragraphs;

    private LoremPresenter presenter;

    public static LoremFragment newInstance() {
        return new LoremFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_lorem;
    }

    @Override
    public void mapGUI(View view) {

        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);

        character = (TextView) view.findViewById(R.id.lorem_character);
        characters = (TextView) view.findViewById(R.id.lorem_characters);

        word = (TextView) view.findViewById(R.id.lorem_word);
        words = (TextView) view.findViewById(R.id.lorem_words);

        sentence = (TextView) view.findViewById(R.id.lorem_sentence);
        sentences = (TextView) view.findViewById(R.id.lorem_sentences);

        paragraph = (TextView) view.findViewById(R.id.lorem_paragraph);
        paragraphs = (TextView) view.findViewById(R.id.lorem_paragraphs);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Lorem");
    }

    @Override
    public void startPresenter() {
        presenter = new LoremPresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }

    @Override
    public void updateCharacterExample(String value) {
        character.setText(value);
    }

    @Override
    public void updateCharactersExample(String value) {
        characters.setText(value);
    }

    @Override
    public void updateWordExample(String value) {
        word.setText(value);
    }

    @Override
    public void updateWordsExample(String value) {
        words.setText(value);
    }

    @Override
    public void updateSentenceExample(String value) {
        sentence.setText(value);
    }

    @Override
    public void updateSentencesExample(String value) {
        sentences.setText(value);
    }

    @Override
    public void updateParagraphExample(String value) {
        paragraph.setText(value);
    }

    @Override
    public void updateParagraphsExample(String value) {
        paragraphs.setText(value);
    }

    @Override
    public void showFeedback(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showView() {
        mainView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideView() {
        mainView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }
}
