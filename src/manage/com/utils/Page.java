package manage.com.utils;

import java.util.List;
import java.util.Map;

public class Page {
	private Integer pageNum;
	private Integer pageSize;
	private Integer pageTotal;
	private Integer start;
	private Integer end;
	private Integer dataSize;// 共多少数据

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	private List list;

	public Page() {
	}

	public Page(Integer pageNum, Integer pageSize, Integer pageTotal, Integer start, Integer end, List list) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.start = start;
		this.end = end;
		this.list = list;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	

	public static Page getPage(int pageIndex, int pageCount, List<Map<String, Object>> sqlResult) {
		Page page = new Page();
		page.setPageNum(pageIndex);
		page.setPageTotal(pageCount);
		page.setList(sqlResult);
		int start = pageIndex - 4;// 使得数据左边有四个，右边有四个
		if (start < 0) {
			start = 0;
		}
		int end = start + 8;
		if (end > page.getPageTotal()) {
			end = page.getPageTotal();
		}
		int seven = 8;
		while (end - start < seven) {
			if (start > 0) {
				start--;
			}
			if (start == 0) {
				break;
			}
		}
		page.setStart(start);
		page.setEnd(end);
		return page;
	}


	public static Page getPage(int pageIndex, int pageCount,int dataSize, List<Map<String, Object>> sqlResult) {
		Page page = new Page();
		page.setPageNum(pageIndex);
		page.setPageTotal(pageCount);
		page.setList(sqlResult);
		page.setDataSize(dataSize);
		int start = pageIndex - 4;// 使得数据左边有四个，右边有四个
		if (start < 0) {
			start = 0;
		}
		int end = start + 8;
		if (end > page.getPageTotal()) {
			end = page.getPageTotal();
		}
		int seven = 8;
		while (end - start < seven) {
			if (start > 0) {
				start--;
			}
			if (start == 0) {
				break;
			}
		}
		page.setStart(start);
		page.setEnd(end);
		return page;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal + ", start=" + start
				+ ", end=" + end + ", list=" + list + "]";
	}

}
