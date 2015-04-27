/**********************************************************************
* Filename: CalendarDate.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class CalendarDate implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class CalendarDate
	***********************************************************/
	public static Set<CalendarDate> allInstances()
	{
		return Database.allInstances(CalendarDate.class);
	}
	
	private Integer day;
	private Integer month;
	private Integer year;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public CalendarDate()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param day the day to initialize
	* @param month the month to initialize
	* @param year the year to initialize
	**********************************************************************/
	public CalendarDate(Integer day, Integer month, Integer year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the day of the calendarDate
	**********************************************************************/
	public Integer day()
	{
		return day;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param day the day to set
	**********************************************************************/
	public void setDay(Integer day)
	{
		this.day = day;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the month of the calendarDate
	**********************************************************************/
	public Integer month()
	{
		return month;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param month the month to set
	**********************************************************************/
	public void setMonth(Integer month)
	{
		this.month = month;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the year of the calendarDate
	**********************************************************************/
	public Integer year()
	{
		return year;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param year the year to set
	**********************************************************************/
	public void setYear(Integer year)
	{
		this.year = year;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param day the day to set
	* @param month the month to set
	* @param year the year to set
	**********************************************************************/
	public void init(Integer day, Integer month, Integer year)
	{
		//	self.day := day; self.month := month; self.year := year
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param date the date to set
	**********************************************************************/
	public void initS(String date)
	{
		//	self.year := date.substring(1,4).toInteger; self.month := date.substring(6,7).toInteger; self.day := date.substring(9,10).toInteger
		this.year = Integer.parseInt(date.substring(0, 3));
		this.month = Integer.parseInt(date.substring(5, 6));
		this.day = Integer.parseInt(date.substring(8, 9));
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isAfter(CalendarDate t)
	{
		//	return if (self.year = t.year) then if (self.month = t.month) then (self.day > t.day) else (self.month > t.month) endif else (self.year > t.year) endif
		return this.year == t.year ? this.month == t.month ? this.day > t.day : this.month > t.month : this.year > t.year;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isBefore(CalendarDate t)
	{
		//	return if (self.year = t.year) then if (self.month = t.month) then (self.day < t.day) else (self.month < t.month) endif else (self.year < t.year) endif
		return this.year == t.year ? this.month == t.month ? this.day < t.day : this.month < t.month : this.year < t.year;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param x the x to set
	* @param y the y to set
	**********************************************************************/
	public Boolean isDivisible(Integer x, Integer y)
	{
		//	return (((x div y) * y) = x)
		return x / y * y == x;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isEqual(CalendarDate t)
	{
		//	return (((self.year = t.year) and (self.month = t.month)) and (self.day = t.day))
		return this.year == t.year && this.month == t.month && this.day == t.day;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public Boolean isLeap()
	{
		if (isDivisible(this.year, 400) || isDivisible(this.year, 4))
			return true;
		else
			if (isDivisible(this.year, 100))
				return false;
			else
				if (isDivisible(this.year, 4))
					return true;
				else
					return false;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public Boolean isValid()
	{
		//	return ((((self.month >= 1) and (self.month <= 12)) and (self.day >= 1)) and if self.isLeap() then (self.day <= Sequence {31,29,31,30,31,30,31,31,30,31,30,31}->at(self.month)) else (self.day <= Sequence {31,28,31,30,31,30,31,31,30,31,30,31}->at(self.month)) endif)
		Integer[] regularDays	= {31,28,31,30,31,30,31,31,30,31,30,31};
		Integer[] leapDays		= {31,29,31,30,31,30,31,31,30,31,30,31};
		
		return this.month >= 1 && this.month <= 12 && this.day >= 1 && 
					this.isLeap() ? this.day <= leapDays[month-1] : this.day <= regularDays[month-1];
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param date the date to set
	**********************************************************************/
	public CalendarDate stringToDate(String date)
	{
		//	declare date_year : String, date_month : String, date_day : String; date_year := date.substring(1,4); date_month := date.substring(6,7); date_day := date.substring(9,10); result := CalendarDate.allInstances->select(cd : CalendarDate | (((cd.year = date_year.toInteger) and (cd.month = date_month.toInteger)) and (cd.day = date_day.toInteger)))->asSequence->first; if result.isUndefined then result := new CalendarDate(((('D' + date_year) + date_month) + date_day)); result.initS(date) end
		CalendarDate temp = new CalendarDate();
		temp.initS(date);
			
		for (CalendarDate d: allInstances())
			if (d.equals(temp))
				return d;
							
		Database.insert(temp);
		return temp;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public String toString()
	{
		//	return self.year.toString.concat('/').concat(self.month.toString).concat('/').concat(self.day.toString)
		return "" + this.year + '-' + this.month + '-' + this.day;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Integer yearsSince(CalendarDate t)
	{
		//	return if ((self.month < t.month) or ((self.month = t.month) and (self.day < t.day))) then ((self.year - t.year) - 1) else (self.year - t.year) endif
		if (this.month < t.month || this.month == t.month && this.day < t.day)
			return this.year - t.year -1;
		else
			return this.year - t.year;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkDateIsValid();
		checkDatesAreDistinct();
	}
	
	public void checkDateIsValid()
	{
		//	self.isValid()
		boolean invariant = (0 < day && day <= 31) && (0 < month && month <= 12) && (year.toString().length() == 4);
		
		assert invariant : "The current date must be a valid one";
	}
	
	public void checkDatesAreDistinct()
	{
		//	CalendarDate.allInstances->isUnique($elem21 : CalendarDate | $elem21.toString())
		boolean invariant = true;
		
		assert invariant : "CalendarDate objects contain distinct dates";
	}
	
	/**********************************************************************
	* @param other CalendarDate to compare to the current one
	* @return 0 if the argument is equal to the current CalendarDate;
	* a value less than 0 if the argument is greater than the current CalendarDate;
	* and a value greater than 0 if the argument is less than this CalendarDate.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof CalendarDate;
		
		//	return this.day.compareTo(((CalendarDate) other).day);
		//	return this.month.compareTo(((CalendarDate) other).month);
		//	return this.year.compareTo(((CalendarDate) other).year);
		return this.isBefore((CalendarDate) other) ? -1 : this.equals(other) ? 0 : 1;
	}
	
	/**********************************************************************
	* @param other CalendarDate to check equality to the current one
	* @return true if the argument is equal to the current CalendarDate and false otherwise
	**********************************************************************/
	@Override
	public boolean equals(Object other)
	{
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		
		final CalendarDate another = (CalendarDate) other;
		if (!super.equals(another))
			return false;
		if ((this.day == null) ? (another.day != null) : !this.day.equals(another.day))
			return false;
		if ((this.month == null) ? (another.month != null) : !this.month.equals(another.month))
			return false;
		if ((this.year == null) ? (another.year != null) : !this.year.equals(another.year))
			return false;
		
		return true;
	}
	
}
