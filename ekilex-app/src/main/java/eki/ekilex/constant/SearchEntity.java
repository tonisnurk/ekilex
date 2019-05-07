package eki.ekilex.constant;

import java.util.List;

import static java.util.Arrays.asList;

public enum SearchEntity {

	HEADWORD(new SearchKey[] {SearchKey.VALUE, SearchKey.LANGUAGE, SearchKey.SOURCE_REF, SearchKey.SOURCE_NAME, SearchKey.CREATED_OR_UPDATED_ON}),
	WORD(new SearchKey[] {SearchKey.VALUE, SearchKey.LANGUAGE, SearchKey.SOURCE_REF, SearchKey.SOURCE_NAME}),
	FORM(new SearchKey[] {SearchKey.VALUE, SearchKey.LANGUAGE}),
	DEFINITION(new SearchKey[] {SearchKey.VALUE, SearchKey.LANGUAGE, SearchKey.SOURCE_REF, SearchKey.SOURCE_NAME}),
	USAGE(new SearchKey[] {SearchKey.VALUE, SearchKey.LANGUAGE, SearchKey.SOURCE_REF, SearchKey.SOURCE_NAME}),
	MEANING(new SearchKey[] {SearchKey.DOMAIN, SearchKey.CREATED_OR_UPDATED_ON}),
	NOTE(new SearchKey[] {SearchKey.VALUE, SearchKey.SOURCE_REF, SearchKey.SOURCE_NAME}),
	CONCEPT_ID(new SearchKey[] {SearchKey.ID}),
	CLUELESS(new SearchKey[] {SearchKey.VALUE})
	;

	private SearchKey[] keys;

	SearchEntity(SearchKey[] keys) {
		this.keys = keys;
	}

	public SearchKey[] getKeys() {
		return keys;
	}

	public static List<SearchEntity> getLexEntities() {
		return asList(HEADWORD, WORD, FORM, MEANING, DEFINITION, USAGE);
	}

	public static List<SearchEntity> getTermEntities() {
		return asList(HEADWORD, MEANING, DEFINITION, USAGE, NOTE, CONCEPT_ID, CLUELESS);
	}
}
