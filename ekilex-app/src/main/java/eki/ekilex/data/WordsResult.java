package eki.ekilex.data;

import java.util.List;

public class WordsResult extends PagingResult {

	private static final long serialVersionUID = 1L;

	private int totalCount;

	private List<Word> words;

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
}
