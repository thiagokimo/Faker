package io.kimo.faker.fragment;

import android.view.View;
import android.widget.TextView;

import io.kimo.faker.BaseFragment;
import io.kimo.faker.R;
import io.kimo.lib.faker.Faker;

public class LoremFragment extends BaseFragment {

    private TextView character, characters, word, words, sentence, sentences, paragraph, paragraphs;

    public static LoremFragment newInstance() {
        return new LoremFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_lorem;
    }

    @Override
    public void mapGUI(View view) {

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

        character.setText(Faker.with(getActivity()).Lorem.character());
        characters.setText(Faker.with(getActivity()).Lorem.character());

        word.setText(Faker.with(getActivity()).Lorem.word());
        words.setText(Faker.with(getActivity()).Lorem.words());

        sentence.setText(Faker.with(getActivity()).Lorem.sentence());
        sentences.setText(Faker.with(getActivity()).Lorem.sentence());

        paragraph.setText(Faker.with(getActivity()).Lorem.paragraph());
        paragraphs.setText(Faker.with(getActivity()).Lorem.paragraphs());
    }
}
